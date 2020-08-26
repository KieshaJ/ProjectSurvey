import React from "react";
import {
    Switch,
    Route
} from "react-router-dom";
import "./SecondarySideNav.css";

import SurveyList from "../survey/list/SurveyList";

function SecondarySideNav() {
    return (
        <Switch>
            <Route path="/surveys">
                <SurveyList/>
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

export default SecondarySideNav;