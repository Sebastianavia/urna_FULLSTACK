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
        console.log(this.user.totalVotos);
    }


    render = ()=>{

        let component = document.createElement('div');
        component.className = 'candidateComponent';
        let fotoCandidato = document.createElement('img');
        fotoCandidato.src = this.user.fotoCandidato;
        fotoCandidato.className = 'imagenCandidato';
        fotoCandidato.innerHTML = this.user.fotoCandidato;
        let votarBtn = document.createElement('votarBtn');
        votarBtn.innerHTML = 'Votar';
        votarBtn.className = 'vote';

        component.appendChild(fotoCandidato);
        component.appendChild(votarBtn)

        votarBtn.addEventListener('click' , this.addVote); 
        return component;
    }
}