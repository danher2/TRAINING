import { types } from '../types/types';

//Hook para 

// estado inicial de nuestro hook
const initialState = {
    loading: false,
    msgError: null
}



//tipo de aciones que se llaman
export const uiReducer = ( state = initialState, action ) => {

    // manejar los actions types dierentes 
    switch ( action.type ) {
        case types.uiSetError:
            return {
                ...state,
                msgError: action.payload
            }

        case types.uiRemoveError:
                return {
                    ...state,
                    msgError: null
                }

        case types.uiStartLoading:
            return {
                ...state,
                loading: true
            }
 
        case types.uiFinishLoading:
            return {
                ...state,
                loading: false
            }

        default:
            return state;
    }

}
