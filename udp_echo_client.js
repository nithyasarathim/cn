const dgram = require('dgram');
const client = dgram.createSocket('udp4');

const msg = Buffer.from("Hi message from UDP client");

client.send(msg, 4550, "localhost", (err)=>{
    if(err) console.log(err);
    else console.log("Message sent");
});

client.on('message',(msg)=>{
    console.log("Server replied : ", msg.toString());

    client.close();
})
