import React from 'react';
import { Card, CardTitle } from 'material-ui/Card';
import Greeter from './Greeter.jsx';

const HomePage = () => (
  <Card className="container">
    <Greeter name="Ninja" />
  </Card>
);

export default HomePage;