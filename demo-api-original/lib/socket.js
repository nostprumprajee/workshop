const io = require('socket.io-client')
const config = require('../config')
const socket = io(config.socket.url)
module.exports = socket

socket._topics = {}
socket.on('connect', () => {
  console.log('socket ready')
  socket.emit('signin', {
    user: config.socket.user,
    pass: config.socket.pass,
  })
  Object.keys(socket._topics).forEach(topic => socket.subscribe(topic))
  if (socket.ready) {
    socket.ready()
  }
})
socket.publish = function(topic, payload) {
  socket.emit('publish', topic, payload)
}
socket.subscribe = function(topic, cb) {
  if (socket._topics[topic]) {
    socket.off(topic, socket._topics[topic])
  }
  socket._topics[topic] = cb
  socket.emit('subscribe', topic)
}
socket.unsubscribe = function(topic) {
  if (socket._topics[topic]) {
    socket.off(topic, socket._topics[topic])
  }
  delete socket._topics[topic]
  socket.emit('unsubscribe', topic)
}

