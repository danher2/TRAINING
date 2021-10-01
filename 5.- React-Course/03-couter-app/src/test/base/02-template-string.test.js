import '@testing-library/jest-dom';
import { getSaludo } from "../../base/02-template-string";

describe('Pruebas en 02-template-string.js',()=>{

test('prueba en el metodo getSaludo', ()=>{

const nombre = 'Daniel';

const saludo =  getSaludo(nombre);

console.log(saludo);


expect(saludo).toBe('Hola ' + nombre + '!');


})


// getSaludo debe de retornar Hola Carlos! si no hay argumento en el nombre
test('getSaludo debe de retornar Hola Carlos! si no hay argumento en el nombre ', () => {
    
    const saludo =  getSaludo();

console.log(saludo);


expect(saludo).toBe('Hola Carlos!');

})



})