


//Arreglos en JS
//const arreglo = new Array(100);
const arreglo = [1,2,3,4];

//arreglo.push(1);
//arreglo.push(2);
//arreglo.push(3);
//arreglo.push(4);

//anadimos un nuevo elemento al array extrayendo sus elementos y agregando uno nuevo
let arreglo2 = [...arreglo,5]; // agregando el valor clonando el arreglo
const arreglo3 = arreglo2.map(function(numero){
        return numero * 2; // por cada elemento numero enviado en el argumento se le multiplique por 2

});




console.log(arreglo);
console.log(arreglo2);
console.log(arreglo3);