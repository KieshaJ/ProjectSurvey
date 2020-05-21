import React, {useState, useEffect} from "react";
import {
    Grid,
    Tooltip,
} from "@material-ui/core";
import {
    Home,
    HomeWork,
    Edit,
    Settings,
    PhotoLibrary
} from "@material-ui/icons";
import {
    Link
} from "react-router-dom";
import "./PrimarySideNav.css";

function PrimarySideNav(props) {
    const [activeLink, setActiveLink] = useState(0);

    const activateLink = () => {
        switch (window.location.pathname) {
            case "/surveys":
                setActiveLink(1);
                break;
            case "/editor":
                setActiveLink(2);
                break;
            case "/images":
                setActiveLink(3);
                break;
            case "/settings":
                setActiveLink(4);
                break;
            default:
                setActiveLink(0);
        }
    };

    const handleLinkClick = (linkIndex, secondaryNav, toolPalette) => {
        props.showSecondaryNav(secondaryNav);
        props.showToolPalette(toolPalette);

        setActiveLink(linkIndex);
    };

    useEffect(() => activateLink());

    return (
        <Grid id="side-nav-1" item xs={1} container direction="column" justify="center" alignItems="center">
            <Tooltip title="Home" placement="right" className="tooltip" arrow>
                <Link
                    to="/"
                    className={activeLink === 0 ? "link active" : "link"}
                    onClick={() => handleLinkClick(0, false, false)}
                >
                    <Home className="icon"/>
                </Link>
            </Tooltip>
            <Tooltip title="Surveys" placement="right" className="tooltip" arrow>
                <Link
                    to="/surveys"
                    className={activeLink === 1 ? "link active" : "link"}
                    onClick={() => handleLinkClick(1, true, false)}
                >
                    <HomeWork className="icon"/>
                </Link>
            </Tooltip>
            <Tooltip title="Editor" placement="right" className="tooltip" arrow>
                <Link
                    to="/editor"
                    className={activeLink === 2 ? "link active" : "link"}
                    onClick={() => handleLinkClick(2, true, true)}
                >
                    <Edit className="icon"/>
                </Link>
            </Tooltip>
            <Tooltip title="Images" placement="right" className="tooltip" arrow>
                <Link
                    to="/images"
                    className={activeLink === 3 ? "link active" : "link"}
                    onClick={() => handleLinkClick(3, true, true)}
                >
                    <PhotoLibrary className="icon"/>
                </Link>
            </Tooltip>
            <Tooltip title="Settings" placement="right" className="tooltip" arrow>
                <Link
                    to="/settings"
                    className={activeLink === 4 ? "link active" : "link"}
                    onClick={() => handleLinkClick(4, true, false)}
                >
                    <Settings className="icon"/>
                </Link>
            </Tooltip>
        </Grid>
    );
}

export default PrimarySideNav;