using System;
using System.Collections.Generic;

namespace EklavyaDotNet.Models
{
    public partial class EnrollDetail
    {
        public long EnrollDetailId { get; set; }
        public long? CourseId { get; set; }
        public float? Price { get; set; }
        public long? InstId { get; set; }
    }
}
