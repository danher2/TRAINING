

//objetos 

const persona = {
    nombre: 'tony',
    apellido: 'stark',
    edad: 45,
    direccion: {
        ciudad: 'New york',
        CP: '6466374',
        lat: '47.8877',
        lng: '34.876574',
    }

};


//console.table({persona});


//extraer todos los atributos de un objeto
const persona2 = {...persona}; //operador spread ... clonamos el objeto haciendo esto , com extraer todos los atributos del objeto pero modificar uno?
persona2.nombre = 'Peter'; // accedemos al atributo objeto del nuevo nombre y lo modificamos

//imprimimos dos objetos diferentes

console.log(persona);
console.log(persona2);