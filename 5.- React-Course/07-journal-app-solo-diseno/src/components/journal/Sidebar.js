import React from 'react'
import { JournalEntries } from './JournalEntries'

//barra lateral  derecha que se ve en el JournalScreen
export const Sidebar = () => {
    return (
        <aside className="journal__sidebar"> {/**aside para indicar que esta a un lado */}
            
            <div className="journal__sidebar-navbar">
                <h3 className="mt-5">
                    <i className="far fa-moon"></i> {/** usamos iconnos de font-awesome */}
                    <span> Daniel</span>
                </h3>

                <button className="btn">
                    Logout
                </button>
            </div>

            <div className="journal__new-entry">
                <i className="far fa-calendar-plus fa-5x"></i> {/**font-awesome */}
                <p className="mt-5">
                    New entry
                </p>
            </div>

            <JournalEntries />    

        </aside>
    )
}
