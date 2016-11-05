import React from 'react';
import ReactDOM from 'react-dom';
import midlinkBaseTheme from 'midlinkBaseTheme';
import lightBaseTheme from 'material-ui/styles/baseThemes/lightBaseTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import injectTapEventPlugin from 'react-tap-event-plugin';
import Greeter from './Greeter.jsx';
import Menubar from './Menubar.jsx';
import Bottom from './Bottom.jsx';

import 'font-awesome/scss/font-awesome.scss';
import '../stylesheets/style.scss';

injectTapEventPlugin();

ReactDOM.render((
        <MuiThemeProvider muiTheme={getMuiTheme(midlinkBaseTheme)}>
            <div>
            <Menubar />
            <h1>Playframework, React JS, ES 6 and webpack</h1>
            <Greeter name="Ninja" />
            <Bottom/>
            </div>
        </MuiThemeProvider>
    ), document.getElementById("app"));