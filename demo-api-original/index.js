const express = require('express')
const bodyParser = require('body-parser')
const config = require('./config')
const socket = require('./lib/socket')

// const session = require('express-session')
// const MongoDBStore = require('connect-mongodb-session')(session)

// const store = new MongoDBStore({
//   uri: process.env.MONGODB || 'mongodb://localhost:27017/eec-session',
//   collection: 'sessions'
// })

const app = express()

const compression = require('compression')
app.use(compression({
  filter: (req, res) => (!req.headers['x-no-compression'] && compression.filter(req, res)) || false,
}))

app.use(express.static('public'))

app.use((req, res, next) => {
  var header = { 'Access-Control-Allow-Origin': '*' }
  for (var i in req.headers) {
    if (i.toLowerCase().substr(0, 15) === 'access-control-') {
      header[i.replace(/-request-/g, '-allow-')] = req.headers[i]
    }
  }
  res.header(header)
  next()
})

app.use(bodyParser.json())
// app.set('trust proxy', 1) // trust first proxy
// app.use(session({
//   secret: 'eec!secret',
//   store,
//   cookie: {
//     maxAge: 15 * 60 * 1000, // 15min
//     // secure: true,
//   },
//   rolling: true,
//   resave: true,
//   saveUninitialized: true,
// }))

app.use((req, res, next) => {
  req.db = require('./lib/db')
  next()
})

app.use((req, res, next) => {
  req.$socket = socket
  next()
})

app.use('/api', require('./api'))

app.listen(config.port, () => {
  console.log('ready', config.port)
})

// setInterval(() => {
//   let num = ('' + Math.floor(Math.random() * 1000000)).padStart(6, '0')
//   console.log('lotto=', num)
//   socket.publish('lotto', num)
// }, 5000)