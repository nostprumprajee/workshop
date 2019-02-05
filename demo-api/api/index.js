const express = require('express')
const router = express.Router()
module.exports = router

router.use('/student', require('./student'))
// router.use('/activity', require('./activity'))
// router.use('/classroom', require('./classroom'))
// router.use('/building', require('./building'))