import React from 'react';
import ReactDOM from 'react-dom';
import midlinkBaseTheme from 'midlinkBaseTheme';
import lightBaseTheme from 'material-ui/styles/baseThemes/lightBaseTheme';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import injectTapEventPlugin from 'react-tap-event-plugin';
import { browserHistory, Router } from 'react-router';
import routes from './routes.js';

import 'font-awesome/scss/font-awesome.scss';
import '../stylesheets/style.scss';

injectTapEventPlugin();

ReactDOM.render((
        <MuiThemeProvider muiTheme={getMuiTheme(midlinkBaseTheme)}>
            <Router history={browserHistory} routes={routes} />
        </MuiThemeProvider>
    ), document.getElementById("app"));