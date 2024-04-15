using System.Collections.Generic;
using System.Linq;
using EklavyaDotNet.Models;
using Microsoft.AspNetCore.Mvc;

namespace EklavyaDotNet.Controllers
{
    [Route("api/elearning/admin/users")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly eklavyaContext _context;

        public UserController(eklavyaContext context)
        {
            _context = context;
        }

        // GET: api/User
        [HttpGet]
        public IEnumerable<User> Get()
        {

            return _context.Users.ToList();
        }

        // GET: api/User/5
       /* [HttpGet("{id}")]
        public ActionResult<User> Get(long id)
        {
            var user = _context.Users.FirstOrDefault(u => u.UserId == id);
            if (user == null)
            {
                return NotFound();
            }
            return Ok(user);
        }*/

        // POST: api/User
        [HttpPost]
        public ActionResult<User> Post([FromBody] User user)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            _context.Users.Add(user);
            _context.SaveChanges();

            return CreatedAtAction(nameof(Get), new { id = user.UserId }, user);
        }

        // PUT: api/User/5
      /*  [HttpPut("{id}")]
        public IActionResult Put(long id, [FromBody] User user)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != user.UserId)
            {
                return BadRequest();
            }

            var existingUser = _context.Users.FirstOrDefault(u => u.UserId == id);
            if (existingUser == null)
            {
                return NotFound();
            }

            _context.Entry(existingUser).CurrentValues.SetValues(user);
            _context.SaveChanges();

            return NoContent();
        }*/


        // DELETE: api/User/5
        [HttpDelete("{id}")]
        public IActionResult Delete(long id)
        {
            Console.WriteLine(id);
            var user = _context.Users.FirstOrDefault(u => u.UserId == id);
            if (user == null)
            {
                return NotFound();
            }

            _context.Users.Remove(user);
            _context.SaveChanges();

            return Ok(user);
        }
    }
}
