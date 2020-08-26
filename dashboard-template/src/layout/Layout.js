import React, {useState, useEffect} from "react";
import {
    Grid,
} from "@material-ui/core";
import "./Layout.css";

import PrimarySideNav from "../components/primarySideNav/PrimarySideNav";
import SecondarySideNav from "../components/secondarySideNav/SecondarySideNav";
import Main from "../components/main/Main";
import ToolPalette from "../components/toolPalette/ToolPalette";

function Layout() {
    const [secondarySideNav, setSecondarySideNav] = useState(false);
    const [toolPalette, setToolPalette] = useState(false);
    const breadcrumb = window.location.pathname;

    const showSecondaryNav = (value) => {
        setSecondarySideNav(value);
    };

    const showToolPalette = (value) => {
        setToolPalette(value);
    }

    const activateBlocks = (pathname) => {
        if(pathname !== "/") {
            showSecondaryNav(true);
        }
        if(pathname.includes("/editor") || pathname.includes("/images")) {
            showToolPalette(true);
        }
    };

    const renderSecondarySideNav = () => {
        if (secondarySideNav) {
            return (
                <Grid id="side-nav-2" item xs={2} container direction="column" alignItems="center">
                    <SecondarySideNav/>
                </Grid>
            );
        }
    };

    const renderMain = () => {
        let columns = 11;

        if (secondarySideNav) {
            columns -= 2;
        }

        if (toolPalette) {
            columns -= 2;
        }

        return (
            <Grid id="main" item xs={columns} container direction="column" justify="center" alignItems="center">
                <Main/>
            </Grid>
        );
    };

    const renderToolPalette = () => {
        if (toolPalette) {
            return (
                <Grid id="side-nav-3" item xs={2} container direction="column" justify="center" alignItems="center">
                    <ToolPalette/>
                </Grid>
            );
        }
    };

    useEffect(() => activateBlocks(breadcrumb));

    return (
        <Grid container>
            <Grid id="top-nav" container direction="row" justify="center" alignItems="center">
                <Grid id="brand" item xs={3} container direction="row" justify="center" alignItems="center">
                    <pre>Brand</pre>
                </Grid>
                <Grid id="breadcrumb" item xs={7} container direction="row" justify="center" alignItems="center">
                    <pre>{breadcrumb}</pre>
                </Grid>
                <Grid id="user" xs={2} item container direction="row" justify="center" alignItems="center">
                    <pre>User</pre>
                </Grid>
            </Grid>
            <Grid container>
                <PrimarySideNav showSecondaryNav={showSecondaryNav} showToolPalette={showToolPalette}/>
                {renderSecondarySideNav()}
                {renderMain()}
                {renderToolPalette()}
            </Grid>
            <Grid id="footer" container direction="row" justify="center" alignItems="center">
                <pre>Footer</pre>
            </Grid>
        </Grid>
    );
}

export default Layout;