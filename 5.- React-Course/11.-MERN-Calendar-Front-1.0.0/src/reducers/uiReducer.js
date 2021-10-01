import { types } from "../types/types";

const initialState = {
    modalOpen: false,
}

//ESTE ES EL QUE DEVUELVE EL ESTADO ACTUAL, EL QUE TIENE EL ESTADO

export const uiReducer = ( state = initialState, action ) => {

    switch ( action.type ) {
        case types.uiOpenModal:
            return {
                ...state, // despues de la coma es por que se le anade  algo mas o tmb espara modifciar al gun atributo ya existente
                modalOpen: true 
            }

        case types.uiCloseModal:
            return {
                ...state,
                modalOpen: false
            }
    
        default:
            return state;
    }


}