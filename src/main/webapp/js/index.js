const candidato = document.getElementById('candidato');
const votos = document.getElementById('votos');
const regBtn = document.getElementById('regBtn');
const candidateConteiner  = document.getElementById('candidateConteiner');





const getAllUsers = () =>{
    let number = numberImg;
    console.log(number);

    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json =  xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            for(let i = 0; i < response.length ; i++){
            let userDTO = new User(response[i].id,response[i].candidato,response[i].votos,response[i].foto);
            let view = new UserView(userDTO);
            usersContainer.appendChild( view.render() );
            }
        }
    });
    xhr.open('GET', 'http://localhost:8080/urna_FULLSTACK/api/candidatos/allCan');
    xhr.send();
};

getAllUsers();
