import React,{useState,useEffect} from 'react';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import styled from 'styled-components'
import Button from '@mui/material/Button';
import { Withdraw } from './services/withdraw';

const Container = styled.div`
  margin: 30px 40px;
  gap: 15px;
  display: flex;
`


function App() {
  const [money, setMoney] = useState(0);
  const [notes, setNotes] = useState({});

  const OnClick = () => {
    Withdraw(money, ({data}) => setNotes(data)) 
  }
  

  return (
    <Container>
      <FormControl>
        <InputLabel htmlFor="outlined-adornment-amount">Saque</InputLabel>
        <OutlinedInput
          id="outlined-adornment-amount"
          value={money}
          onChange={({target}) => setMoney(target.value)}
          startAdornment={<InputAdornment position="start">R$</InputAdornment>}
          label="Amount"
          type="number"
          size="small"
        />
       </FormControl>
       <Button onClick={() => OnClick()} variant="contained">Saque</Button>
       <br />
       <br />
       <div>
         {notes && Object.entries(notes).map(note => (
            <div>
              {note[1]} notas de R$ {note[0]} <br />
            </div>
         ))}
       </div>
    </Container>
  );
}

export default App;
