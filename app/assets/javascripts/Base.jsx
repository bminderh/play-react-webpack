import React, { PropTypes } from 'react';
import { Link, IndexLink } from 'react-router';
import Menubar from './Menubar.jsx';
import Bottom from './Bottom.jsx';


const Base = ({ children }) => (
  <div>
    <Menubar />
    <h1>Circle</h1>
      {children}
    <Bottom/>
  </div>
);

Base.propTypes = {
  children: PropTypes.object.isRequired
};

export default Base;