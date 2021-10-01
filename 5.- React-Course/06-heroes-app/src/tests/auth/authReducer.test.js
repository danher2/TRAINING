import { authReducer } from "../../auth/authReducer"
import { types } from "../../types/types";

describe('Pruebas en authReducer', () => {
    
    test('debe de retornar el estado por defecto', () => {
        
        //reducer regresa un state  estado inicial logged en false y la actin un bjeto vacio
        const state = authReducer({ logged: false }, {});
        // esperp que el estado sea un logged false
        expect( state ).toEqual({ logged: false });

    })

    test('debe de autenticar y colocar el name del usuario', () => {
        //creamos la accion importamos los types creamos un objeto  semejante al que usamos de verdad
        const action = {
            type: types.login,
            payload: {
                name: 'Hernando'
            }
        }

        //mandamos la accion al reducer
        const state = authReducer({ logged: false }, action);
        //esperaria que el logged sea true y con el nombre de hernando
        expect( state ).toEqual({ 
            logged: true,
            name: 'Hernando'
        });

    })

    test('debe de borrar el name del usuario y logged en false', () => {
        //tenemo la accion de logout
        const action = {
            type: types.logout
        }

        //estado por defecto logged true name pEdro
        const state = authReducer({ logged: true, name: 'Pedro' }, action);
        // esperaria que el logged sea false con el logout
        expect( state ).toEqual({ logged: false });

    })
    

})
