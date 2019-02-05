const express = require('express')
const router = express.Router()

module.exports = router

router.post('/', async (req, res) => {
  // 1. check require
  if (!req.body.login || !req.body.pass) {
    return res.send({
      ok: false,
      message: 'กรุณาตรวจสอบชื่อผู้ใช้งานและรหัสผ่าน',
    })
  }

  let rows = await req.db('user')
    .where('login', '=', req.body.login || '')
    .where('pass', '=', req.body.pass || '')
  if (rows.length === 0) {
    return res.send({
      ok: false,
      message: 'ชื่อผู้ใช้งานหรือรหัสผ่าน ไม่ถูกต้อง',
    })
  }

  let user = rows[0]

  // TODO: save ข้อมูลลง session
  // req.session.data = user
  req.$socket.publish('login', `${user.name} is logged in`)
  
  res.send({
    ok: true,
    user,
  })
})
