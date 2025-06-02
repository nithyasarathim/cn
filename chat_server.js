const net = require ('net');

const server = net.createServer((socket)=>{
    console.log("New client connected");

    socket.on('data',(data)=>{
        const msg = data.toString();
        console.log("Client said :", msg);
        socket.write(`You said : ${msg}`);  
    });

    socket.on('end',()=>{
        console.log("Connection closed");
    });
});

server.listen(4550, 'localhost', ()=>{
    console.log('chat server is running on http://localhost:4550');
});