using DevTour.Database;
using Microsoft.EntityFrameworkCore;
using Model;

namespace agenciaviagens3.Repository
{
    public class ClienteFisicoRepository : IClienteRepository
    {
        private readonly ClienteFisicoDbContext _context;

        public ClienteFisicoRepository(ClienteFisicoDbContext context) {
            _context = context;
        }

        public void AddClienteFisico(ClienteFisico clientefisico)
        {
            _context.Add(clientefisico);
        }

        public void AtualizarClienteFisico(ClienteFisico clientefisico)
        {
            _context.Update(clientefisico);
        }

        public void DeletarClienteFisico(ClienteFisico clientefisico)
        {
            _context.Remove(clientefisico);
        }

        public async Task<ClienteFisico> GetClienteFisicoById(int IDCF)
        {
            return await _context.ClientesFisicos.Where(x => x.IDCF == ICF).FirstOrDefaultAsync();
        }

        public async Task<IEnumerable<ClienteFisico>> GetClientesFisicos()
        {
            return await _context.Clientes.ToListAsync();
        }

        public async Task<bool> SaveChangesAsync()
        {
            return await _context.SaveChangesAsync() > 0;
        }
    }
}