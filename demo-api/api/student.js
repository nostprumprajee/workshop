const express = require('express')
const router = express.Router()
module.exports = router

router.get('/', (req, res) => {
  res.send("<h1>Student</h1>")
})

router.get('/list', (req, res) => {
  res.send("<h1>List Student</h1>")
})