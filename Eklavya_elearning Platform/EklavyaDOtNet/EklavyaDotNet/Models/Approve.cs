using System;
using System.Collections.Generic;

namespace EklavyaDotNet.Models
{
    public partial class Approve
    {
        public long ApvId { get; set; }
        public string? Certifications { get; set; }
        public string? Description { get; set; }
        public string? Experience { get; set; }
        public string? Qualification { get; set; }
        public string? UStatus { get; set; }
        public long? UserId { get; set; }
    }
}
