import React from 'react';
import { Sidebar } from './Sidebar';
import { NoteScreen } from '../notes/NoteScreen';
// import { NothingSelected } from './NothingSelected';


export const JournalScreen = () => {
    
    //no function because its just a screen
    
    return (
        <div className="journal__main-content"> {/**estilo que engloba toda la pantalla */}
            
            <Sidebar />


            <main> {/** el resto de pagina principal que me sobra */}

                {/* <NothingSelected /> */}
                <NoteScreen />

            </main>


        </div>
    )
}
