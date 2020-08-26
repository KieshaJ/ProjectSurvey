import React from "react";
import {
    Switch,
    Route
} from "react-router-dom";
import "./ToolPalette.css";

class ToolPalette extends React.Component {
    render() {
        return(
            <Switch>
                <Route path="/editor">
                    Editor
                </Route>
                <Route path="/images">
                    Images
                </Route>
            </Switch>
        );
    }
}

export default ToolPalette;