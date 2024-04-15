using System;
using System.Collections.Generic;

namespace EklavyaDotNet.Models
{
    public partial class Order
    {
        public int OrdId { get; set; }
        public string? Username { get; set; }
        public float? TotalAmt { get; set; }
        public string? OrdDate { get; set; }
        public long? UserUserId { get; set; }

        public virtual User? UserUser { get; set; }
    }
}
