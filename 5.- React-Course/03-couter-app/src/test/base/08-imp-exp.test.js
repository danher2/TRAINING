import { getHeroeById, getHeroesByOwner } from "../../base/08-imp-exp";
import heroes from "../../data/heroes";

describe('Pruebas en funciones de heroes', ()=>{

test('Debe retornar un heroe por id', ()=>{
        
    const id = 1;

    const heroe = getHeroeById(id);
    console.log(heroe);

    const heroeData=heroes.find(h=>h.id===id);
    expect(heroe).toEqual(heroeData);
});

test('Debe retornar undefined si heroe no existe', ()=>{
        
    const id = 10;

    const heroe = getHeroeById(id);
    console.log(heroe);

    expect(heroe).toBe(undefined); // retorna undefined si el heroe no existe
});

//1 Debe de retornar un arreglo con los heroes de DC
//owner (arreglo)
// toEqual al arreglo del producto
test('Debe de retornar un arreglo con los heroes de DC', ()=>{
        
    const owner = 'DC';

    const heroesDC = getHeroesByOwner(owner);
    console.log(heroesDC);
    const findHeroe = heroes.filter( (heroe) => heroe.owner === owner );
    
    expect(heroesDC).toEqual(findHeroe);

 
});


//2 Debe de retornar un arreglo con los heroes de Marvel
//length =2 -> toBe

test('Debe de retornar un arreglo con los heroes de Marvel', ()=>{
        
    const owner = 'Marvel';

    const heroesDC = getHeroesByOwner(owner);
    console.log(heroesDC.length);
    expect(heroesDC.length).toBe(2);
    
    
    // expect(heroesDC).toEqual(findHeroe);

 
});



})