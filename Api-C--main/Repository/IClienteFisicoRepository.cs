using Model;

namespace alfabetizando3.Repository
{
    public interface IClienteFisicoRepository
    {
        Task<IEnumerable<ClienteFisico>> GetClientesFisicos();
        Task<Cliente> GetClienteFisicoById(int id);

        void AddClienteFisico(ClienteFisico clientefisico);
        void AtualizarClienteFisico(ClienteFisico clienteFisico);
        void DeletarClienteFisico(ClienteFisico clienteFisico);

        Task<bool> SaveChangesAsync();
        
    }
}