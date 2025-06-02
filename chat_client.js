const net =require('net');
const readline =require('readline');

const client= new net.Socket();

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

client.connect(4550, 'localhost',()=>{
    console.log('Connected to server');
    rl.prompt();
});

client.on('data',(data)=>{
    console.log(data.toString());
    rl.prompt();
})

rl.on('line',(line)=>{
    client.write(line);
})

client.on('close',()=>{
    console.log("Connection Closed");
    rl.close();
});