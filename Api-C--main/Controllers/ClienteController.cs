using DevTour.Repository;
using Microsoft.AspNetCore.Mvc;
using Model;

namespace alfabetizando3.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class clientefisicoFisicoController : ControllerBase
    {
        private readonly IclientefisicoFisicoRepository _repository;

        public clientefisicoFisicoController(IclientefisicoFisicoRepository repository) {
            _repository = repository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll(){
            var clientefisicos = await _repository.GetclientefisicosFisicos();
            return clientefisicosfisicos.Any() ? Ok(clientefisicosfisicos) : NoContent();
        }  
        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(int id){
            var clientefisico = await _repository.GetclientefisicoById(id);
            return clientefisico != null ? Ok(clientefisico) : NotFound("clientefisico não encontrado.");
        }  
        [HttpPost]
        public async Task<IActionResult> Post(clientefisico clientefisico){
            _repository.Addclientefisico(clientefisico);
            return await _repository.SaveChangesAsync() ? Ok("clientefisico adicionado") : BadRequest("Algo deu errado");
        }
        [HttpPut("{id}")]
        public async Task<IActionResult> Atualizar(int id, clientefisico clientefisico) {
            var clientefisicoExiste = await _repository.GetclientefisicoById(id);

            if(clientefisicoExiste == null) return NotFound("clientefisico não encotrado");
            
            clientefisicoExiste.Nome = clientefisico.Nome ?? clientefisicoExiste.Nome;
            clientefisicoExiste.Sobrenome = clientefisico.Sobrenome != new DateTime() ? clientefisico.Sobrenome : clientefisicoExiste.Sobrenome;

            _repository.Atualizarclientefisico(clientefisicoExiste);

            return await _repository.SaveChangesAsync() ? Ok("´clientefisico Atualizado.") : BadRequest("Algo deu errado.") ;
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(int id) {
            var clientefisicoExiste = await _repository.GetclientefisicoById(id);
            if(clientefisicoExiste == null)
            return NotFound("clientefisico não encontrado.");

            _repository.Deletarclientefisico(clientefisicoExiste);
             return await _repository.SaveChangesAsync() ? Ok("´clientefisico deletado.") : BadRequest("Algo deu errado.") ;
        }
    }
}