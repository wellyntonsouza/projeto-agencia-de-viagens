namespace Model
{
    public class Viagem
    {
       public int IdViagem {get; set;}
       public int IdCj {get; set;}
       public string Partida {get; set;}

       public string Destino {get; set;}
       public DateTime Data {get; set;}
       public double Valor {get; set;}
    }
}