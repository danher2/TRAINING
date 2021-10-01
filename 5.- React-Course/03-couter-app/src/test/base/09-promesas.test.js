import { getHeroeByIdAsync } from "../../base/09-promesas";
import heroes from "../../data/heroes";

describe('Pruebas con promesa',()=>{

test('getHeroeByIdAsync debe de retornar un heroe Async',(done)=>{

    //given
const id=1;

//when
getHeroeByIdAsync(id)
    .then(heroe=>{

    expect(heroe).toBe(heroes[0]);
    done();
})

});


test('getHeroeByIdAsync debe de retornar un error si el heroe por id no existe',(done)=>{

    //givenn
const id=10;

//when
getHeroeByIdAsync(id)
    .catch(error=>{

        expect(error).toBe('No se pudo encontrar el héroe');
        done();
    });

});


})