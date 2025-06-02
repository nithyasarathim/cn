const dgram = require('dgram');
const server = dgram.createSocket('udp4');

server.bind(4550, 'localhost');

server.on('listening',()=>{
    console.log(`server is listening on :localhost:4550`);
});

server.on('message',(msg, rinfo)=>{
    console.log(`Received message :`,msg.toString());

    server.send(msg, rinfo.port, rinfo.server,(err)=>{
        if(err){
            console.log("Error : ", err);
        }
    });
})