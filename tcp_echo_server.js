const net = require("net");
const server = net.createServer((socket)=>{
    console.log("Connection Established");

    socket.on("data",(data)=>{
        console.log("CLIENT SAID :",data.toString());
        socket.write(data.toString());
    })

    socket.on("close", ()=>{
        console.log("Connection closed");
    })
});

server.listen(4550,'localhost',()=>{
    console.log("Server is running on http://localhost:4550");
})

