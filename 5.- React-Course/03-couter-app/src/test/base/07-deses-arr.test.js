import { retornaArreglo } from "../../base/07-deses-arr"

describe('Pruebas en desestructuracion', ()=>{

    test('debe de retornar un string y un numero', ()=>{

        const [letras,numeros] = retornaArreglo();
       
        // expect(arr).toEqual(['ABC',123]);

       console.log(typeof letras); 
       console.log(typeof numeros); 


       expect(letras).toBe('ABC');
       expect(typeof letras).toBe('string');
       
       expect(numeros).toBe(123);
       expect(typeof numeros).toBe('number');

        

    })

})