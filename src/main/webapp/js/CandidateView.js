class CandidateView{

    constructor(candidate){
        this.candidate = candidate;
    }

    addVote = ()=>{
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',()=>{
            if(xhr.readyState===4){
                window.alert('Voto registrado ');
            }
        });
        xhr.open('PUT','http://localhost:8080/urna_FULLSTACK/api/candidatos/addVote/'+this.candidate.id)
        xhr.send();
        console.log(this.candidate.votos);
    }


    render = ()=>{

        let component = document.createElement('div');
        component.className = 'candidateComponent';
        let foto = document.createElement('img');
        foto.src = this.candidate.foto;
        foto.className = 'imagen';
        foto.innerHTML = this.candidate.foto;
        let votarBtn = document.createElement('votarBtn');
        votarBtn.innerHTML = 'Votar';
        votarBtn.className = 'vote';

        component.appendChild(foto);
        component.appendChild(votarBtn)

        votarBtn.addEventListener('click' , this.addVote); 
        return component;
    }
}