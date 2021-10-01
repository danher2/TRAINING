import { types } from '../types/types';
/*
    {
        uid: 'jagdfjahdsf127362718',
        name: 'Fernando'
    }

*/
//los redicers reciben nuestro state y el action
//state vacio cuando no este autenticado
export const authReducer = ( state = {}, action ) => {

    //las acciones se manejan siempre con un switch
    switch ( action.type ) { // llamamos el type de la action
        case types.login: // login
            return {
                uid: action.payload.uid,
                name: action.payload.displayName
            }

        case types.logout:
                return { } // retorna un objeto vacio 
    
        default:
            return state;
    }

}