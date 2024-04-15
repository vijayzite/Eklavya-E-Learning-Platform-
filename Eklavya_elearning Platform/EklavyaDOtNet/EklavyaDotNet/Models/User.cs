using System;
using System.Collections.Generic;

namespace EklavyaDotNet.Models
{
    public partial class User
    {
        public User()
        {
            Courses = new HashSet<Course>();
            Orders = new HashSet<Order>();
        }

        public long UserId { get; set; }
        public string? Address { get; set; }
        public string? Email { get; set; }
        public string? FirstName { get; set; }
        public string? LastName { get; set; }
        public string? Pass { get; set; }
        public string? PhoneNo { get; set; }
        public string? Username { get; set; }
        public int? RoleRoleId { get; set; }

        public virtual Role? RoleRole { get; set; }
        public virtual ICollection<Course> Courses { get; set; }
        public virtual ICollection<Order> Orders { get; set; }
    }
}
