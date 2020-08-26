import React from "react";
import {
    Switch,
    Route
} from "react-router-dom";
import "./Main.css";

function Main() {
    return(
        <Switch>
            <Route path="/" exact>
                Home
            </Route>
            <Route path="/surveys">
                Surveys
            </Route>
            <Route path="/editor">
                Editor
            </Route>
            <Route path="/images">
                Images
            </Route>
            <Route path="/settings">
                Settings
            </Route>
        </Switch>
    );
}

export default Main;