const http = require('http');

const server = http.createServer(function(req,res){
  res.setHeader('Content-Type', 'application/json');
  res.write(JSON.stringify({ msg: '你好啊' }));
  res.end();
});

server.listen(8080);

console.log('服务启动');
