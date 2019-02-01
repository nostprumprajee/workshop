const express = require('express') // โหลด module express

const app = express() // สร้าง Instance express


app.use((req, res, next) => {
    console.log('LOGGED')
    next()
  })
app.get('/', (req, res) => {
    res.send({id : 1, name: 'Nost'})
  })



app.listen(5000, () => console.log('Example app listening on port 5000!')) // Start Server ที่ localhost Port 5000