import { todoReduce } from "../../../components/08-useReducer/todoReduce"
import { demoTodos } from "../../fixtures/demoTodos";




describe('Prueba en todoReduce', () => {

    

    test('debe retornar el estado por defecto ', () => {
        
        const state = todoReduce(demoTodos, {});
        expect(state).toEqual(demoTodos);

    });
    
    
    
    test('debe agregar un todo', () => {

        // return state.filter(todo => todo.id !== action.payload);
        const newTodo = {
            id: 3,
            desc: 'Aprender Express',
            donde: false
        }

        const action = {
            type: 'add',
            payload: newTodo
        }

       
        const state = todoReduce(demoTodos, action);
        expect(state.length).toBe(3);
        //si quieres ser mas especifico
        expect(state).toEqual([...demoTodos, newTodo]);

        //debe agregar un todo



    });


    test('debe Borrar un TODO ', () => {
      
        const action = {
            type: 'delete',
            payload: 1
        }
        const state = todoReduce(demoTodos, action);
        //solo quedo un elemento en state
        expect(state.length).toBe(1);
        
        //el unico elemento de state es igual al segundo elemento de demotodos
        expect(state).toEqual([demoTodos[1]]);
        
        
    })

    
    
    test('debe de hacer el toggle del TODO ', () => {
        
        const action = {
            type: 'toggle',
            payload: 1
        }
        const state = todoReduce(demoTodos, action);
        expect(state[0].done).toBe(true);
        //el segundo elemento del state sea igual al segundo elemento del demoTodos
        expect(state[1]).toEqual(demoTodos[1]);
        
    })


    
    
    
})