const personajes = ['goku','vegeta','trunks'];

//desestructuracion de arreglos con corchetes
const [] = personajes;

//desestructuramos respetando las posiciones en este caso la tercera porcision es trunks
const[ , ,p2] = personajes;

//imprimimos a trunks
console.log(p2);

//esta funciion retorna un arreglos
const retornaArregle = () => {
return ['ABC', 123];// ---> nota que retorna un arreglo pero es una funcion

}

//desestructuramos elementos del un arreglo que es devuelto por una funcion
const [letras,numeros] = retornaArregle();
console.log(letras,numeros);


//funcion que retorna un arreglo
useState = (valor) => {
    return [valor, ()=>{console.log('Hola mundo')}];
}

// como useState devuelve un arreglo, lo podemos desestructurar
const [nombre, setNombre] = useState('Goku');
console.log(nombre);

//llamamos al segundo elemento del arreglo y como es una funcion por eso le añadimos los parentesis
setNombre(); // esta funcion es el segundo elemento del arreglo que devuelve useState




