import Container from 'react-bootstrap/Container';
import { Navbar, Nav } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';

function NavBar() {
	return (
		<Navbar expand='lg'>
			<Container>
				<LinkContainer to='/'>
					<Navbar.Brand>Field Agents</Navbar.Brand>
				</LinkContainer>
				<Navbar.Toggle aria-controls='basic-navbar-nav' />
				<Navbar.Collapse id='basic-navbar-nav'>
					<Nav className='me-auto'>
						<LinkContainer to='/' end='true'>
							<Nav.Link>Home</Nav.Link>
						</LinkContainer>
						<LinkContainer to='/agents'>
							<Nav.Link>Agents</Nav.Link>
						</LinkContainer>
						<LinkContainer to='/agencies'>
							<Nav.Link>Agencies</Nav.Link>
						</LinkContainer>
						<LinkContainer to='/security-clearances'>
							<Nav.Link>Security Clearances</Nav.Link>
						</LinkContainer>
					</Nav>
				</Navbar.Collapse>
			</Container>
		</Navbar>
	);
}

export default NavBar;
