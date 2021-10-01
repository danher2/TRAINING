import { getUser, getUsuarioActivo } from "../../base/05-funciones";

describe('Prueba en 05-funciones', ()=>{

    test('getUSer debe de retornar un objeto', ()=>{

        const userTest= {
            uid: 'ABC123',
            username: 'El_Papi1502'
            }

        const user = getUser();

        console.log(user);

        expect(user).toEqual(userTest);


    })


    //getUsuarioActivo debe de retornar un objeto

    test('getUsuarioActivo debe de retornar un objeto', ()=>{

        const nombre = 'Daniel';
        const userActivo = getUsuarioActivo(nombre);
        console.log(userActivo);

        expect(userActivo).toStrictEqual({
            uid: 'ABC567',
            username: nombre
        });


    })

}
);