module.exports = {
  snakeToCamel,
  camelToSnake,
}

function snakeToCamel(s) {
  let newObj = {}
  Object.keys(s).forEach(k => {
    newObj[k.toLowerCase().replace(/(\w)(_\w)/g, m => m[0] + m[2].toUpperCase())] = s[k]
  })
  return newObj
}

function camelToSnake(s) {
  return s.replace(/[A-Z]/g, m => '_' + m[0].toLowerCase())
}
