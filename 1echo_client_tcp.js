const net=require('net');

const client = new net.Socket();
client.connect(4550, 'localhost', ()=>{
    console.log("Connection Established");
    client.write("Hello world");
});

client.on("data",(data)=>{
    console.log("Server replied : ", data.toString());
    client.end();
})



client.on("close", ()=>{
    console.log("Connection closed")
})