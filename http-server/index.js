var http = require('http')
var server = http.createServer(function (request, response){
  console.info('123')
  response.writeHead(200, {
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
  })
  response.write(JSON.stringify({
    data: 'Hello'
  }))
  response.end()
}).listen(1337, '127.0.0.1', function() {
  console.info('sever: 127.0.0.1:1337...')
})