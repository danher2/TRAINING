//OPERADORES TERNARIOS
//forma corta de hacer una desicion

const activo = true;
// let mensaje = '';

// if(activo){

//   mensaje = 'Activo';
// }else{
//   mensaje = 'Inactivo';
// }


//OPERADORES TERNARIOS  Patron => const msg1 = (if-arg-true) ? iftrue : iffalse  o  (condition) ? true : false
const mensaje1 = !(activo) ? 'Activo' : 'Inactivo';
const mensaje2 = !(activo) ? 'Activo' : null; // in the case that you dont want to do nothing  if the condition is false
const mensaje3 = !activo && 'Activo'; // si la condicion es true  usamos &&  pero si fuera la negacion tendriamos un falso

console.log(mensaje1);
console.log(mensaje2);
console.log(mensaje3);

